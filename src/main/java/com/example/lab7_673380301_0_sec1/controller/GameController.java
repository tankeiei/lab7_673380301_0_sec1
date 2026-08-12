package com.example.lab7_673380301_0_sec1.controller;

import com.example.lab7_673380301_0_sec1.model.Game;
import com.example.lab7_673380301_0_sec1.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;

    // Constructor Injection
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/games";
    }

    @GetMapping("/games")
    public String listGames(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "games/list";
    }

    @GetMapping("/games/add")
    public String showAddForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    @PostMapping("/games/save")
    public String saveGame(@ModelAttribute("game") Game game, RedirectAttributes redirectAttributes) {
        gameService.saveGame(game);
        redirectAttributes.addFlashAttribute("message", "เพิ่มข้อมูลเกม '" + game.getTitle() + "' สำเร็จเรียบร้อยแล้ว");
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Game game = gameService.getGameById(id);
        if (game == null) {
            return "redirect:/games";
        }
        model.addAttribute("game", game);
        return "games/edit";
    }

    @PostMapping("/games/update/{id}")
    public String updateGame(@PathVariable("id") Long id, @ModelAttribute("game") Game game, RedirectAttributes redirectAttributes) {
        game.setId(id);
        gameService.saveGame(game);
        redirectAttributes.addFlashAttribute("message", "แก้ไขข้อมูลเกม '" + game.getTitle() + "' เรียบร้อยแล้ว");
        return "redirect:/games";
    }

    @GetMapping("/games/delete/{id}")
    public String showDeleteConfirm(@PathVariable("id") Long id, Model model) {
        Game game = gameService.getGameById(id);
        if (game == null) {
            return "redirect:/games";
        }
        model.addAttribute("game", game);
        return "games/delete";
    }

    @PostMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Game game = gameService.getGameById(id);
        String title = (game != null) ? game.getTitle() : "";
        gameService.deleteGameById(id);
        redirectAttributes.addFlashAttribute("message", "ลบข้อมูลเกม '" + title + "' ออกจากระบบเรียบร้อยแล้ว");
        return "redirect:/games";
    }
}
