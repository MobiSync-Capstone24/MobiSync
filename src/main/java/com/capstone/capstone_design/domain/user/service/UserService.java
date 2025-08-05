package com.capstone.capstone_design.domain.user.service;

import com.capstone.capstone_design.domain.user.model.Users;
import com.capstone.capstone_design.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users getAuthenticatedUser() {
        Long userId = getAuthenticatedUserId();
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user"));
    }

    public Long getAuthenticatedUserId() {
        return 1L; // 테스트용 ID, 후에 변경
    }

    @Transactional(readOnly = true)
    public Users getMyInfo(){
        return getAuthenticatedUser(); // 후에 customDTO 변환 필요
    }

    @Transactional
    public void updateMyInfo(Object requestDto){
        Users user = getAuthenticatedUser();
        // user.updateNickname(requestDto.getNickname());

        userRepository.save(user);
    }

    @Transactional
    public void deleteMyAccount(){
        Users user = getAuthenticatedUser();
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public Object getMyTastes() {
        Users user = getAuthenticatedUser();
        return user.getUserTaste(); // 후에 DTO 변환 필요
    }

    @Transactional
    public void updateMyTastes(Object requestDto){
        Users user = getAuthenticatedUser();
        // 맛 변경
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Object getMyDibs(){
        return getAuthenticatedUser().getDibsList(); // DTO 변환 필요
    }

    @Transactional(readOnly = true)
    public Object getMyOrders(){
        return getAuthenticatedUser().getOrders();
    }

    @Transactional(readOnly = true)
    public Object getMyReviews(){
        return getAuthenticatedUser().getReviews();
    }

    @Transactional(readOnly = true)
    public Object getMyCoupons(){
        return getAuthenticatedUser().getUserCoupons();
    }

    @Transactional
    public void issueCoupon(Object couponRequestDto){
        Users user = getAuthenticatedUser();
        // 쿠폰 생성 로직, 어떤 방식으로 할지 고민
    }
}
