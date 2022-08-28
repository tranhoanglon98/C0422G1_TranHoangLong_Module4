package com.example.case_study_module_4.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dich_vu")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer id;

    @Column(name = "ten_dich_vu")
    private String name;

    @Column(name = "dien_tich")
    private Integer area;

    @Column(name = "chi_phi_thue")
    private Double cost;

    @Column(name = "so_nguoi_toi_da")
    private Integer maxPeople;

    @Column(name = "tieu_chuan_phong")
    private String standardRoom;

    @Column(name = "mo_ta_tien_nghi_khac")
    private String otherConvenient;

    @Column(name = "dien_tich_ho_boi")
    private Double poolArea;

    @Column(name = "so_tang")
    private Integer floors;

    @Column(name = "dich_vu_mien_phi_di_kem")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue",referencedColumnName = "ma_kieu_thue")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu",referencedColumnName = "ma_loai_dich_vu")
    private FacilityType facilityType;
}
