package com.example.case_study_module_4.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loai_khach")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_khach")
    private Integer id;

    @Column(name = "ten_loai_khach")
    private String name;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

}
