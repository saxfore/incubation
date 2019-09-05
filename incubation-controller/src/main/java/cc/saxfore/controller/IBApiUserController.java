package cc.saxfore.controller;

import cc.saxfore.annotation.IBApiURL;
import cc.saxfore.entity.IBUser;
import cc.saxfore.model.IBResponse;
import cc.saxfore.service.IBUserService;
import cc.saxfore.utils.IBRespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：IndexController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:31 PM
 * 创 建 人：wangjiang
 */
@Api(value = "app端操作用户信息的contoller")
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
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IBResponse list() {
        List<IBUser> userList = service.listAll();
        return IBRespResult.success(userList);
    }

    /**
     * 查询单个用户明细
     *
     * @param id
     * @return
     */
    @IBApiURL
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IBResponse detail(@PathVariable(value = "id") String id) {
        IBUser user = service.selectByPrimaryKey(id);
        return IBRespResult.success(user);
    }

}
