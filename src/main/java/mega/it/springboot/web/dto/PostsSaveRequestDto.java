package mega.it.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mega.it.springboot.domain.posts.Posts;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {

  private String title;
  private String content;
  private String author;

  @Builder
  public PostsSaveRequestDto(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public Posts toEntity() {
    return Posts.builder()
        .title(title)
        .content(content)
        .author(author)
        .build();
  }
}