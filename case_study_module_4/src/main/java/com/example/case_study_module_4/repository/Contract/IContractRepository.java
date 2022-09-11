package com.example.case_study_module_4.repository.Contract;

import com.example.case_study_module_4.dto.ContractDto;
import com.example.case_study_module_4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "SELECT \n" +
            "        hd.ma_hop_dong AS id,\n" +
            "            hd.ngay_lam_hop_dong AS startDay,\n" +
            "            hd.ngay_ket_thuc AS endDay,\n" +
            "            hd.tien_dat_coc AS deposit,\n" +
            "            kh.ho_ten AS customerName,\n" +
            "            dv.ten_dich_vu AS facilityName,\n" +
            "            (dv.chi_phi_thue + SUM(IFNULL(dvdk.gia * hdct.so_luong, 0))) AS total\n" +
            "    FROM\n" +
            "        hop_dong AS hd\n" +
            "    LEFT JOIN hop_dong_chi_tiet AS hdct ON hd.ma_hop_dong = hdct.ma_hop_dong\n" +
            "    LEFT JOIN dich_vu_di_kem AS dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem\n" +
            "    LEFT JOIN khach_hang AS kh ON hd.ma_khach_hang = kh.ma_khach_hang\n" +
            "    LEFT JOIN dich_vu AS dv ON dv.ma_dich_vu = hd.ma_dich_vu\n" +
            "    GROUP BY hd.ma_hop_dong",nativeQuery = true,countQuery = "select count(*) from hop_dong")
    Page<ContractDto> findAllContractWithTotal(Pageable pageable);

}
