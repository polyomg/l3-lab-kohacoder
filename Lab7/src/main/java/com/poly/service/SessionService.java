package com.poly.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Đặt giá trị vào session
     * @param name tên thuộc tính
     * @param value giá trị cần lưu
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Lấy giá trị từ session
     * @param name tên thuộc tính
     * @return giá trị hoặc null nếu không tồn tại
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    /**
     * Lấy giá trị từ session, nếu không có thì trả về giá trị mặc định
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return (value != null) ? value : defaultValue;
    }

    /**
     * Xóa thuộc tính khỏi session
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
