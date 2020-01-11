package com.alibaba.study.usercenter.rocketmq;

import com.alibaba.study.usercenter.dao.user.UserMapper;
import com.alibaba.study.usercenter.dao.bonusevent.BonusEventLogMapper;
import com.alibaba.study.usercenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.alibaba.study.usercenter.domain.entity.bonusevent.BonusEventLog;
import com.alibaba.study.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: wjy
 * @Date: 2020/1/11 23:04
 */
@Service
@RocketMQMessageListener(consumerGroup = "consume-group", topic = "add_bonus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        //1 为用户加积分
        Integer userId = userAddBonusMsgDTO.getUserId();
        User user = this.userMapper.selectByPrimaryKey(userId);
        Integer bonus = userAddBonusMsgDTO.getBonus();
        //不做非空校验了
        user.setBonus(user.getBonus() + bonus);
        this.userMapper.updateByPrimaryKey(user);

        //2 记录日志
        this.bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(bonus)
                .event("contribute")
                .createTime(new Date())
                .description("投稿加积分")
                .build());
    }
}
