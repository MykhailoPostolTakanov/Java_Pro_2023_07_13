package heromvc;

import JDBC.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import patternsandtesting.HeroService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HeroMVCController {
    private final HeroService heroService;

    @GetMapping
    public String heroes(Model model) {
        model.addAttribute("Name", "Test");
        model.addAttribute("heroes", heroService.getHeroes());
        return "heroes/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        var hero = heroService.getHeroesByID(id);
        model.addAttribute("hero", hero);
        return "heroes/edit";
    }

    @PostMapping("/update")
    public String update(Hero hero, Model model) {
        heroService.updateHero(hero);
        return "redirect:/";
    }
}
