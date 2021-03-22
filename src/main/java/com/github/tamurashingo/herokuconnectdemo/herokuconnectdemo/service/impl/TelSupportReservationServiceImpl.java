package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.impl;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller.request.TelSupportReservationForm;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TelSupportReservationMapper;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.TelSupportReservation;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.TelSupportReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TelSupportReservationServiceImpl implements TelSupportReservationService {

    private final TelSupportReservationMapper mapper;

    public TelSupportReservationServiceImpl(final TelSupportReservationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<TelSupportReservation> findAll() throws TelSupportReservationException {
        return mapper.selectAll();
    }

    @Override
    public TelSupportReservation findById(String externalid) throws TelSupportReservationException {
        return mapper.selectByKey(externalid);
    }

    @Override
    public void createReservation(TelSupportReservationForm form) throws TelSupportReservationException {
        if (!isNotCreatedTargetdate(form.getTargetDate())) {
            throw new TelSupportReservationException(form.getTargetDate() + "はすでに枠作成済みです");
        }

        List<TelSupportReservation> reservations = generateTargetTime(form.getStartDate(), form.getEndDate(), form.getMinutes()).
                stream().
                map((final LocalTime startTime) -> {
                            return new TelSupportReservation(
                                    null,
                                    "e-" + form.getTargetDate().atTime(startTime).toString(),
                                    "空き",
                                    null,
                                    null,
                                    null,
                                    null,
                                    form.getTargetDate().atTime(startTime),
                                    form.getTargetDate().atTime(startTime.plusMinutes(form.getMinutes())));
                        }).
                collect(Collectors.toList());

        for (TelSupportReservation r: reservations) {
            System.out.println("予約枠:" + r.getStartDatetime() + " ~ " + r.getEndDatetime());
            mapper.insert(r);
        }
    }


    /**
     * 指定した日の枠数が0であること（未作成であること）
     *
     * @param targetDate 指定した日
     * @return 枠未作成の場合 true
     */
    private boolean isNotCreatedTargetdate(LocalDate targetDate) {
        LocalDateTime startDate = targetDate.atTime(0, 0,0);
        LocalDateTime endDate = targetDate.atTime(23, 59, 59);

        Long count = mapper.selectCountByTargetdate(startDate, endDate);

        return count == 0L;
    }

    /**
     * 開始時刻、終了時刻、サポート時間をもとに各枠の時刻を作成する
     * @param startTime 開始時刻
     * @param endTime 終了時刻
     * @param minutes 時間
     * @return 開始時刻〜終了時刻の枠情報
     */
    private List<LocalTime> generateTargetTime(LocalTime startTime, LocalTime endTime, int minutes) {
        List<LocalTime> list = new ArrayList<>();

        // 生成範囲を開始時刻〜終了時刻内に抑えるため、事前に指定時刻を引いておく
        // 10:00~18:30 で サポート時刻が 20 分の場合、18:00~18:20 の枠までが作成される
        endTime = endTime.minusMinutes(minutes);

        for (LocalTime time = startTime; !time.isAfter(endTime); time = time.plusMinutes(minutes)) {
            list.add(time);
        }
        return list;
    }
}
