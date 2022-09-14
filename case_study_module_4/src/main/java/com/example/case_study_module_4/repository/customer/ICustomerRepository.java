package com.example.case_study_module_4.repository.customer;

import com.example.case_study_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    @Query(value = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    khach_hang\n" +
            "WHERE\n" +
            "    ma_khach_hang IN (SELECT \n" +
            "            khach_hang.ma_khach_hang\n" +
            "        FROM\n" +
            "            khach_hang\n" +
            "                JOIN\n" +
            "            hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang\n" +
            "        WHERE\n" +
            "            hop_dong.ngay_ket_thuc > :now" +
            "                AND khach_hang.ho_ten LIKE :name" +
            "        GROUP BY khach_hang.ma_khach_hang)",nativeQuery = true,countQuery = "SELECT \n" +
            "    COUNT(*)\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        khach_hang.ma_khach_hang\n" +
            "    FROM\n" +
            "        khach_hang\n" +
            "    JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang\n" +
            "    WHERE\n" +
            "        hop_dong.ngay_ket_thuc > '2022-09-12'\n" +
            "            AND khach_hang.ho_ten LIKE '%nhi%'\n" +
            "    GROUP BY khach_hang.ma_khach_hang) AS su_dung")
    Page<Customer> getUsingCustomer(@Param("now") String now,@Param("name") String name, Pageable pageable);
}
