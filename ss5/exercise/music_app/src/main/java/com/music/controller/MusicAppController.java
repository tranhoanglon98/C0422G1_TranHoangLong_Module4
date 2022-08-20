package com.music.controller;


import com.music.model.Song;
import com.music.model.SongForm;
import com.music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String goHome(Model model) {
        model.addAttribute("songList", this.iSongService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String goAddPage(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getType(), fileName);
        this.iSongService.save(song);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String goUpdatePage(@RequestParam int id, Model model) {
        Song song = this.iSongService.findById(id);
        SongForm songForm = new SongForm();
        BeanUtils.copyProperties(song, songForm);
        model.addAttribute("songForm", songForm);
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute SongForm songForm) {
        Song oldSong = this.iSongService.findById(songForm.getId());
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Song song = new Song(oldSong.getId(), songForm.getName(), songForm.getArtist(), songForm.getType(), fileName);
        if (song.getPath().equals("")) {
            song.setPath(oldSong.getPath());
        }
        this.iSongService.update(song);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.iSongService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/listen")
    public String Listen(@RequestParam int id, Model model) {
        model.addAttribute("song", this.iSongService.findById(id));
        return "listen";
    }
}
