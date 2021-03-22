package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TelSupportReservation {

    /** id */
    private Long id;
    /**
     * 外部ID
     * アプリ側はこの値がユニークになるように生成すること
     */
    private String externalId;
    /** 空き状況 */
    private String emptyStatus;
    /** 種別 */
    private String type;
    /** Salesforce側の自動生成（のハズ） */
    private String name;

    /** 予約した人 */
    private String reservationCustomer;
    /** 予約した日時 */
    private LocalDateTime reservationDatetime;

    /** サポート開始日時 */
    private LocalDateTime startDatetime;
    /** サポート終了日時 */
    private LocalDateTime endDatetime;
}
