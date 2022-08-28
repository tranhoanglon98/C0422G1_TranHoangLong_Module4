package com.example.case_study_module_4.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khach_hang")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Integer id;

    @Column(name = "ho_ten")
    private String name;

    @Column(name = "ngay_sinh")
    private String dayOfBirth;

    @Column(name = "gioi_tinh",columnDefinition = "bit(1)")
    private Boolean gender;

    @Column(name = "so_cmnd")
    private String idCard;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Email
    private String email;

    @Column(name = "dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_loai_khach",referencedColumnName = "ma_loai_khach")
    private CustomerType customerType;

}
