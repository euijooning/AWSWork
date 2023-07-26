package mega.it.springboot.domain.posts;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mega.it.springboot.web.dto.PostsResponseDto;
import mega.it.springboot.web.dto.PostsSaveRequestDto;
import mega.it.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  public PostsResponseDto findById(Long id){
    Posts entity = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
    return new PostsResponseDto(entity);
  }
}