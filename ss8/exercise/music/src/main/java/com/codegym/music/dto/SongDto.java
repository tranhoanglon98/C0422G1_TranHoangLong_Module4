package com.codegym.music.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(max = 800,message = "Không được quá 800 ký tự")
    @Pattern(regexp = "^[\\w ]+$",message = "Nhập sai định dạng")
    private String name;


    @NotBlank(message = "Không được để trống")
    @Size(max = 300,message = "Không được quá 300 ký tự")
    @Pattern(regexp = "^[\\w ]+$",message = "Nhập sai định dạng")
    private String artist;


    @NotBlank(message = "Không được để trống")
    @Size(max = 1000,message = "Không được quá 1000 ký tự")
    @Pattern(regexp = "^[\\w ,]+$",message = "Nhập sai định dạng")
    private String type;
    private MultipartFile path;
}
