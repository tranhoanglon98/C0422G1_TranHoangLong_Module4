package com.music.controller;


import com.music.model.Song;
import com.music.model.SongForm;
import com.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicAppController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("songList",this.iSongService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String goAddPage(Model model){
        model.addAttribute("songForm",new SongForm());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload  + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(songForm.getName(),songForm.getArtist(),songForm.getType(),fileName);
        this.iSongService.save(song);
        return "redirect:/";
    }
}
