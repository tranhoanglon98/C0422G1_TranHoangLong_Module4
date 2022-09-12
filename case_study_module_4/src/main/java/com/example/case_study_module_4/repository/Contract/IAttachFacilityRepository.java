package com.example.case_study_module_4.repository.Contract;

import com.example.case_study_module_4.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {

    @Query(value = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    dich_vu_di_kem AS dvdk\n" +
            "WHERE\n" +
            "    dvdk.ma_dich_vu_di_kem IN (SELECT \n" +
            "            hdct.ma_dich_vu_di_kem\n" +
            "        FROM\n" +
            "            hop_dong_chi_tiet AS hdct\n" +
            "                JOIN\n" +
            "            dich_vu_di_kem AS dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem\n" +
            "                JOIN\n" +
            "            hop_dong AS hd ON hd.ma_hop_dong = hdct.ma_hop_dong\n" +
            "        WHERE\n" +
            "            hd.ma_hop_dong = ?1)",nativeQuery = true)
    List<AttachFacility> findAttachFacilityByContractId(Integer id);
}
