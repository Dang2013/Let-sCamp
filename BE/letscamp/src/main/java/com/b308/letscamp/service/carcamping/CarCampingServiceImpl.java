package com.b308.letscamp.service.carcamping;

import com.b308.letscamp.exception.CarCampingNotFoundException;
import com.b308.letscamp.exception.ReservationNotFoundException;
import com.b308.letscamp.exception.UserNotFoundException;
import com.b308.letscamp.dto.carcamping.CarCampingFindResponse;
import com.b308.letscamp.dto.carcamping.CarCampingSaveRequest;
import com.b308.letscamp.dto.carcamping.CarCampingUpdateRequest;
import com.b308.letscamp.dto.reservation.ReservationFindResponse;
import com.b308.letscamp.dto.user.UserFindResponse;
import com.b308.letscamp.entity.CarCamping;
import com.b308.letscamp.entity.Reservation;
import com.b308.letscamp.entity.User;
import com.b308.letscamp.repository.CarCampingRepository;
import com.b308.letscamp.repository.ReservationRepository;
import com.b308.letscamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarCampingServiceImpl implements CarCampingService{
    private final CarCampingRepository carCampingRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    @Override
    public Long create(String userId, Long reservationId) {
        CarCampingSaveRequest dto = new CarCampingSaveRequest();

        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserFindResponse userFindResponse = userOptional.map(UserFindResponse::new).orElse(null);
        User user = User.builder()
                .id(userFindResponse.getId())
                .userId(userFindResponse.getUserId())
                .userPw(userFindResponse.getUserPw())
                .nickName(userFindResponse.getNickName())
                .exp(userFindResponse.getExp())
                .address(userFindResponse.getAddress())
                .build();
        dto.setUser(user);

        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        if (reservationOptional.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        ReservationFindResponse reservationFindResponse = reservationOptional.map(ReservationFindResponse::new).orElse(null);
        Reservation reservation = Reservation.builder()
                .id(reservationFindResponse.getId())
                .build();
        dto.setReservation(reservation);

        dto.setItem("????????? ??????");
        dto.setLevel(3L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????? ????????? ??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???????????? ?????? ??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????? ?????? ??????");
        dto.setLevel(2L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("????????? ?????????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(3L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("????????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???");
        dto.setLevel(2L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???");
        dto.setLevel(3L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(2L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(2L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????/?????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???????????????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("????????????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("????????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("????????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("??????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???????????????");
        dto.setLevel(4L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("???????????? ?????????");
        dto.setLevel(1L);
        carCampingRepository.save(dto.toEntity());

        dto.setItem("?????????");
        dto.setLevel(2L);
        return carCampingRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @Override
    public void delete(String userId, Long reservationId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserFindResponse userFindResponse = userOptional.map(UserFindResponse::new).orElse(null);

        carCampingRepository.deleteByUserIdAndReservationId(userFindResponse.getId(), reservationId);
    }

    @Override
    public List<CarCampingFindResponse> findByUserIdAndReservationId(String userId, Long reservationId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserFindResponse userFindResponse = userOptional.map(UserFindResponse::new).orElse(null);

        return carCampingRepository.findByUserIdAndReservationId(userFindResponse.getId(), reservationId)
                .stream().map(CarCampingFindResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<CarCampingFindResponse> findByUserIdAndReservationIdAndLevel(String userId, Long reservationId, Long level) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserFindResponse userFindResponse = userOptional.map(UserFindResponse::new).orElse(null);

        return carCampingRepository.findByUserIdAndReservationIdAndLevel(userFindResponse.getId(), reservationId, level)
                .stream().map(CarCampingFindResponse::new).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long update(CarCampingUpdateRequest dto) {
        CarCamping carCamping = carCampingRepository.findById(dto.getId()).orElseThrow(CarCampingNotFoundException::new);
        return carCamping.update(dto.isCheck()).getId();
    }
}
