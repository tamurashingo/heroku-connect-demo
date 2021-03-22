package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
/**
 * 予約枠作成用の入力データ
 */
public class TelSupportReservationForm {

    /** 予約枠を作成する日付 */
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate targetDate;

    /** 枠の開始時刻（≒サポート開始時刻） */
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime startDate;
    /** 枠の終了時刻（≒サポート終了時刻） */
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime endDate;

    /** 1枠の時間(15, 20, 30を想定) */
    private int minutes;


    /**
     * 開始時刻、終了時刻のチェック
     *
     * @return 開始時刻 < 終了時刻の場合 true
     */
    @AssertTrue(message = "start date must be earlier than end date.")
    public boolean isStartdateLTEnddate() {
        return (startDate != null && endDate != null) && startDate.isBefore(endDate);
    }

    /**
     * 1枠の時間のチェック
     *
     * @return 15, 20, 30 いずれかの場合 true
     */
    @AssertTrue(message = "minutes must be either 15, 20, 30")
    public boolean isMinutesInRange() {
        return minutes == 15 || minutes == 20 || minutes == 30;
    }


}
