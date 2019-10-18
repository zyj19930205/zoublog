package cn.jxnc.zouyj.blog.controller.info;

import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagControllerInfo {

    @Autowired
    TagService tagService;

    @RequestMapping("/getTags")
    public List<Tag> getTags(){
        List<Tag> tagList=tagService.getAllTags();
        return tagList;
    }

    @RequestMapping("/getTagByName/{tagName}")
    public Integer getTag(@PathVariable String tagName) {
        Integer result=tagService.IsTagExsit(tagName);
        return result;
    }
}
