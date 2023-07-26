package mega.it.springboot.web;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import mega.it.springboot.config.auth.dto.SessionUser;
import mega.it.springboot.domain.posts.PostsService;
import mega.it.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

  private final PostsService postsService;
  private final HttpSession httpSession;

//  @GetMapping("/")
//  public String index(Model model) {
//    model.addAttribute("posts", postsService.findAllDesc());  //posts는 우리가 index.머스테치에서 명명한 이름
//    return "index";
//  }
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());

    SessionUser user = (SessionUser)httpSession.getAttribute("user");

    if (user != null) {
      model.addAttribute("userName1", user.getName());
    }
    return "index";
  }


  @GetMapping("/posts/save")
  public String postSave() {
    return "posts-save";
  }

  @GetMapping("/posts/update/{id}")
  public String postsUpdate(@PathVariable Long id, Model model) {
    PostsResponseDto dto = postsService.findById(id);
    model.addAttribute("post", dto);

    return "posts-update";
  }
}