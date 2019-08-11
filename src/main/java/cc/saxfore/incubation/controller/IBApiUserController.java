package cc.saxfore.incubation.controller;

import cc.saxfore.incubation.annotation.IBApiURL;
import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.model.IBResponse;
import cc.saxfore.incubation.service.IBUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 项目名称：incubation
 * 类 名 称：IndexController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:31 PM
 * 创 建 人：wangjiang
 */
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class IBApiUserController extends IBBaseController {
    private static final Logger log = LoggerFactory.getLogger(IBApiUserController.class);

    @Autowired
    IBUserService service;

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/list")
    public IBResponse list() {
        List<IBUser> userList = service.findUserListByNative();
        return IBRespResult.success(userList);
    }

    /**
     * 查询单个用户明细
     *
     * @param id
     * @return
     */
    @IBApiURL
    @GetMapping("/{id}")
    public IBResponse detail(@PathVariable(value = "id") String id) {
        Optional<IBUser> user = service.findById(id);
        return IBRespResult.success(user.get());
    }

}
