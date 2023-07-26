package mega.it.springboot.web;

import lombok.RequiredArgsConstructor;
import mega.it.springboot.domain.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

  private final PostsService postsService;
//  @GetMapping("/")
//  public String getMustache() {
//    return "index";
//  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());  //posts는 우리가 index.머스테치에서 명명한 이름
    return "index";
  }


  @GetMapping("/posts/save")
  public String postSave() {
    return "posts-save";
  }
}