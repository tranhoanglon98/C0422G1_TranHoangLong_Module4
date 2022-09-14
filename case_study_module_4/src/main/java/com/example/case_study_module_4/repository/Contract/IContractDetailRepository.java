package com.example.case_study_module_4.repository.Contract;

import com.example.case_study_module_4.dto.IContractDetailDto;
import com.example.case_study_module_4.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    hop_dong_chi_tiet\n" +
            "WHERE\n" +
            "    ma_hop_dong IN (SELECT \n" +
            "            hdct.ma_hop_dong\n" +
            "        FROM\n" +
            "            hop_dong_chi_tiet AS hdct\n" +
            "                JOIN\n" +
            "            hop_dong AS hd ON hd.ma_hop_dong = hdct.ma_hop_dong\n" +
            "        WHERE\n" +
            "            hd.ma_hop_dong = ?1); ",nativeQuery = true)
    List<ContractDetail> findContractDetailByContractId(Integer id);


    @Query(value = "SELECT \n" +
            "    dvdk.ma_dich_vu_di_kem AS attachFacilityId,\n" +
            "    dvdk.ten_dich_vu_di_kem AS attachFacilityName,\n" +
            "    dvdk.gia AS cost,\n" +
            "    dvdk.don_vi AS unit,\n" +
            "    dvdk.trang_thai AS status,\n" +
            "    hdct.so_luong AS quantity,\n" +
            "    hdct.ma_hop_dong_chi_tiet AS contractDetailId\n" +
            "FROM\n" +
            "    dich_vu_di_kem AS dvdk\n" +
            "        LEFT JOIN\n" +
            "    (SELECT \n" +
            "        *\n" +
            "    FROM\n" +
            "        hop_dong_chi_tiet\n" +
            "    WHERE\n" +
            "        ma_hop_dong = ?1) AS hdct ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem",nativeQuery = true)
    List<IContractDetailDto> findAllContractDetailByContractId(Integer id);
}
