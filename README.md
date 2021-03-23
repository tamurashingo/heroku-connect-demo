# heroku connect demo application

これは heroku connect のデモアプリです。

## 前提

### Salesforce

Salesforceに以下のカスタムオブジェクトを作成

API参照名: TelSupportReservation__c

| ラベル | API参照名 | データ型 |
| ------- | --------- | -------- |
| サポート終了日時 | `EndDatetime__c` | 日付/時間 |
| サポート開始日時 | `StartDatetime__c` | 日付/時間 |
| 予約した人 | `ReservationCustomer__c` | テキスト(255) |
| 予約した日時 | `ReservationDatetime__c` | 日付/時間 |
| 外部ID | `ExternalId__c` | テキスト(255)(外部ID)(ユニーク) |
| 種別 | `type__c` | 選択リスト(制限なし) |
| 空き状況 | `EmptyStatus__c` | 選択リスト(制限なし) |
| 電話予約Id | Name | 自動採番 |

### Heroku Connect

https://trailhead.salesforce.com/ja/content/learn/projects/develop-heroku-applications/set-up-heroku-connect

このページを参考に、 上記の `TelSupportReservation__c` を Mapping する


## ローカルでの開発

### データベースの準備

docker-compose 等で postgresql を動かします。

```
docker-compose up
```

ビルドするとテストフェーズで勝手にmigrationを行います。


### 実行

ビルドを行い

```
./mvnw clean pacakge
```


jarを指定して起動します。

```
java -jar target/herokuconnectdemo-0.0.1-SNAPSHOT.jar
```

ブラウザで http://localhost:8080/ に接続します。


## heroku にデプロイ

```
git push heroku master
```

でherokuにpushすると勝手にデプロイされます。

### データベース

herokuにpush後、以下のコマンドを実行し、migrationを行います。

```
heroku run migrate
```

### 実行

ブラウザでアクセスします。

```
heroku open
```

---

Copyright &copy; 2021 tamura shingo
Licensed under the [MIT License][MIT].

[MIT]: https://opensource.org/licenses/MIT

