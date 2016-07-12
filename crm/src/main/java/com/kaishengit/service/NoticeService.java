package com.kaishengit.service;

import com.kaishengit.mapper.NoticeMapper;
import com.kaishengit.pojo.Notice;
import com.kaishengit.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 20330 on 2016/7/11.
 */
@Named
public class NoticeService {


   @Inject
    private NoticeMapper noticeMapper;
    /**
     * 保存新的公告
     * @param notice
     */
    public void saveNotice(Notice notice) {
        notice.setUserid(ShiroUtil.getCurrentUserID());
        notice.setRealname(ShiroUtil.getCurrentRealName());
        noticeMapper.save(notice);

        //TODO 微信通知
    }
}
