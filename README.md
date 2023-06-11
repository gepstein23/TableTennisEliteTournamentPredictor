# TableTennisEliteTournamentPredictor
Predicts outcomes of the TT Elite Series tournaments by analyzing previous tournament data (https://www.tt-series.com/)

TODO: Automatically grab latest data and upcoming tourney schedules from https://www.tt-series.com/ (Currently statically parsing from https://www.tt-series.com/1176-results-11-06-2023-afternoom-tournament-hsc/ and predicting input tournaments, as shown below)
TODO: Deduplicate the overall player stats from predictions output

```
-p https://www.tt-series.com/1178-results-11-06-2023-evening-tournament-hsc/ https://www.tt-series.com/1179-results-11-06-2023-night-tournament-osp/ https://www.tt-series.com/1180-results-11-06-2023-night-tournament-hsc/ https://www.tt-series.com/1181-results-12-06-2023-morning-tournament-osp/ https://www.tt-series.com/1182-results-12-06-2023-morning-tournament-hsc/

====================================================================
====================================================================
==========================ALL PREDICTIONS===========================
====================================================================
====================================================================


================================================================================
==  https://www.tt-series.com/1178-results-11-06-2023-evening-tournament-hsc/  ==
================================================================================
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
| MatchTimeEST| Player 1 Name     | Player 2 Name     | Player 1 Stats                                                            | Player 2 Stats                                                            | Predictions                                                     |
|===============================================================================================================================================================================================================================================================================|
| 13:40       | Glanowski, Jakub  | Rutkowski, Mateusz| matchWs 125/265 (47.2%), setWs: 520/1070 (48.6%), tourneyWs: 7/53 (13.2%) | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Glanowski matchWinOdds: 0% (0/3), setWinOdds: 30.8% (4/13)   |
| 14:00       | Minda, Michał     | Misiak, Mateusz   | matchWs 148/250 (59.2%), setWs: 552/1000 (55.2%), tourneyWs: 10/50 (20%)  | matchWs 201/345 (58.3%), setWs: 753/1378 (54.6%), tourneyWs: 14/69 (20.3%)| || Minda matchWinOdds: 78.6% (11/14), setWinOdds: 67.2% (39/58) |
| 14:20       | Radło, Szymon     | Glanowski, Jakub  | matchWs 258/435 (59.3%), setWs: 963/1756 (54.8%), tourneyWs: 24/87 (27.6%)| matchWs 125/265 (47.2%), setWs: 520/1070 (48.6%), tourneyWs: 7/53 (13.2%) | || Radło matchWinOdds: 60% (6/10), setWinOdds: 50% (22/44)      |
| 14:40       | Misiak, Mateusz   | Woźniak, Jakub    | matchWs 201/345 (58.3%), setWs: 753/1378 (54.6%), tourneyWs: 14/69 (20.3%)| matchWs 33/90 (36.7%), setWs: 156/351 (44.4%), tourneyWs: 0/18 (0%)       | || Misiak matchWinOdds: 100% (4/4), setWinOdds: 70.6% (12/17)   |
| 15:00       | Minda, Michał     | Rutkowski, Mateusz| matchWs 148/250 (59.2%), setWs: 552/1000 (55.2%), tourneyWs: 10/50 (20%)  | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Minda matchWinOdds: 42.9% (3/7), setWinOdds: 44.4% (12/27)   |
| 15:40       | Glanowski, Jakub  | Woźniak, Jakub    | matchWs 125/265 (47.2%), setWs: 520/1070 (48.6%), tourneyWs: 7/53 (13.2%) | matchWs 33/90 (36.7%), setWs: 156/351 (44.4%), tourneyWs: 0/18 (0%)       | || Glanowski matchWinOdds: 75% (3/4), setWinOdds: 68.8% (11/16) |
| 16:00       | Radło, Szymon     | Minda, Michał     | matchWs 258/435 (59.3%), setWs: 963/1756 (54.8%), tourneyWs: 24/87 (27.6%)| matchWs 148/250 (59.2%), setWs: 552/1000 (55.2%), tourneyWs: 10/50 (20%)  | || Radło matchWinOdds: 30% (3/10), setWinOdds: 40.5% (17/42)    |
| 16:20       | Misiak, Mateusz   | Rutkowski, Mateusz| matchWs 201/345 (58.3%), setWs: 753/1378 (54.6%), tourneyWs: 14/69 (20.3%)| matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Misiak matchWinOdds: 0% (0/2), setWinOdds: 25% (2/8)         |
| 16:40       | Glanowski, Jakub  | Minda, Michał     | matchWs 125/265 (47.2%), setWs: 520/1070 (48.6%), tourneyWs: 7/53 (13.2%) | matchWs 148/250 (59.2%), setWs: 552/1000 (55.2%), tourneyWs: 10/50 (20%)  | || Glanowski matchWinOdds: 42.9% (6/14), setWinOdds: 45% (27/60)|
| 17:10       | Radło, Szymon     | Misiak, Mateusz   | matchWs 258/435 (59.3%), setWs: 963/1756 (54.8%), tourneyWs: 24/87 (27.6%)| matchWs 201/345 (58.3%), setWs: 753/1378 (54.6%), tourneyWs: 14/69 (20.3%)| || Radło matchWinOdds: 82.4% (14/17), setWinOdds: 69.2% (45/65) |
| 17:30       | Rutkowski, Mateusz| Woźniak, Jakub    | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| matchWs 33/90 (36.7%), setWs: 156/351 (44.4%), tourneyWs: 0/18 (0%)       | || Rutkowski matchWinOdds: 50% (1/2), setWinOdds: 50% (3/6)     |
| 17:50       | Glanowski, Jakub  | Misiak, Mateusz   | matchWs 125/265 (47.2%), setWs: 520/1070 (48.6%), tourneyWs: 7/53 (13.2%) | matchWs 201/345 (58.3%), setWs: 753/1378 (54.6%), tourneyWs: 14/69 (20.3%)| || Glanowski matchWinOdds: 50% (6/12), setWinOdds: 48% (24/50)  |
| 18:10       | Minda, Michał     | Woźniak, Jakub    | matchWs 148/250 (59.2%), setWs: 552/1000 (55.2%), tourneyWs: 10/50 (20%)  | matchWs 33/90 (36.7%), setWs: 156/351 (44.4%), tourneyWs: 0/18 (0%)       | || Minda matchWinOdds: 33.3% (1/3), setWinOdds: 36.4% (4/11)    |
| 18:30       | Radło, Szymon     | Rutkowski, Mateusz| matchWs 258/435 (59.3%), setWs: 963/1756 (54.8%), tourneyWs: 24/87 (27.6%)| matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Radło matchWinOdds: 45.5% (10/22), setWinOdds: 44.3% (39/88) |
================================================================================


================================================================================
==  https://www.tt-series.com/1179-results-11-06-2023-night-tournament-osp/  ==
================================================================================
___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
| MatchTimeEST| Player 1 Name        | Player 2 Name        | Player 1 Stats                                                            | Player 2 Stats                                                            | Predictions                                                          |
|==========================================================================================================================================================================================================================================================================================|
| 15:10       | Kotwica, Dawid       | Kotyl, Krzysztof     | matchWs 103/280 (36.8%), setWs: 459/1092 (42%), tourneyWs: 3/56 (5.4%)    | matchWs 71/325 (21.8%), setWs: 419/1262 (33.2%), tourneyWs: 0/65 (0%)     | || Kotwica matchWinOdds: 64.3% (18/28), setWinOdds: 54% (61/113)     |
| 15:30       | Zochniak, Jakub      | Skórski, Michał      | matchWs 219/355 (61.7%), setWs: 775/1383 (56%), tourneyWs: 20/71 (28.2%)  | matchWs 16/65 (24.6%), setWs: 94/264 (35.6%), tourneyWs: 0/13 (0%)        | || Zochniak matchWinOdds: 100% (7/7), setWinOdds: 75% (21/28)        |
| 15:50       | Mugowski, Arkadiusz  | Poliniewicz, Grzegorz| matchWs 168/345 (48.7%), setWs: 660/1371 (48.1%), tourneyWs: 13/69 (18.8%)| matchWs 216/380 (56.8%), setWs: 811/1493 (54.3%), tourneyWs: 18/76 (23.7%)| || Mugowski matchWinOdds: 36.7% (11/30), setWinOdds: 41.3% (50/121)  |
| 16:10       | Kotwica, Dawid       | Zochniak, Jakub      | matchWs 103/280 (36.8%), setWs: 459/1092 (42%), tourneyWs: 3/56 (5.4%)    | matchWs 219/355 (61.7%), setWs: 775/1383 (56%), tourneyWs: 20/71 (28.2%)  | || Kotwica matchWinOdds: 7.7% (2/26), setWinOdds: 24.2% (23/95)      |
| 16:30       | Poliniewicz, Grzegorz| Kotyl, Krzysztof     | matchWs 216/380 (56.8%), setWs: 811/1493 (54.3%), tourneyWs: 18/76 (23.7%)| matchWs 71/325 (21.8%), setWs: 419/1262 (33.2%), tourneyWs: 0/65 (0%)     | || Poliniewicz matchWinOdds: 94.1% (16/17), setWinOdds: 84.5% (49/58)|
| 17:00       | Mugowski, Arkadiusz  | Skórski, Michał      | matchWs 168/345 (48.7%), setWs: 660/1371 (48.1%), tourneyWs: 13/69 (18.8%)| matchWs 16/65 (24.6%), setWs: 94/264 (35.6%), tourneyWs: 0/13 (0%)        | || Mugowski matchWinOdds: 85.7% (6/7), setWinOdds: 61.3% (19/31)     |
| 17:20       | Zochniak, Jakub      | Kotyl, Krzysztof     | matchWs 219/355 (61.7%), setWs: 775/1383 (56%), tourneyWs: 20/71 (28.2%)  | matchWs 71/325 (21.8%), setWs: 419/1262 (33.2%), tourneyWs: 0/65 (0%)     | || Zochniak matchWinOdds: 90.6% (29/32), setWinOdds: 73.4% (91/124)  |
| 17:40       | Kotwica, Dawid       | Mugowski, Arkadiusz  | matchWs 103/280 (36.8%), setWs: 459/1092 (42%), tourneyWs: 3/56 (5.4%)    | matchWs 168/345 (48.7%), setWs: 660/1371 (48.1%), tourneyWs: 13/69 (18.8%)| || Kotwica matchWinOdds: 29.4% (5/17), setWinOdds: 36.5% (23/63)     |
| 18:05       | Poliniewicz, Grzegorz| Skórski, Michał      | matchWs 216/380 (56.8%), setWs: 811/1493 (54.3%), tourneyWs: 18/76 (23.7%)| matchWs 16/65 (24.6%), setWs: 94/264 (35.6%), tourneyWs: 0/13 (0%)        | || Poliniewicz matchWinOdds: 100% (4/4), setWinOdds: 70.6% (12/17)   |
| 18:20       | Zochniak, Jakub      | Mugowski, Arkadiusz  | matchWs 219/355 (61.7%), setWs: 775/1383 (56%), tourneyWs: 20/71 (28.2%)  | matchWs 168/345 (48.7%), setWs: 660/1371 (48.1%), tourneyWs: 13/69 (18.8%)| || Zochniak matchWinOdds: 47.2% (17/36), setWinOdds: 48.5% (66/136)  |
| 18:40       | Kotwica, Dawid       | Poliniewicz, Grzegorz| matchWs 103/280 (36.8%), setWs: 459/1092 (42%), tourneyWs: 3/56 (5.4%)    | matchWs 216/380 (56.8%), setWs: 811/1493 (54.3%), tourneyWs: 18/76 (23.7%)| || Kotwica matchWinOdds: 0% (0/17), setWinOdds: 17.7% (11/62)        |
| 19:00       | Skórski, Michał      | Kotyl, Krzysztof     | matchWs 16/65 (24.6%), setWs: 94/264 (35.6%), tourneyWs: 0/13 (0%)        | matchWs 71/325 (21.8%), setWs: 419/1262 (33.2%), tourneyWs: 0/65 (0%)     | || Skórski matchWinOdds: 44.4% (4/9), setWinOdds: 43.6% (17/39)      |
| 19:30       | Zochniak, Jakub      | Poliniewicz, Grzegorz| matchWs 219/355 (61.7%), setWs: 775/1383 (56%), tourneyWs: 20/71 (28.2%)  | matchWs 216/380 (56.8%), setWs: 811/1493 (54.3%), tourneyWs: 18/76 (23.7%)| || Zochniak matchWinOdds: 38.5% (10/26), setWinOdds: 40.6% (39/96)   |
| 19:50       | Mugowski, Arkadiusz  | Kotyl, Krzysztof     | matchWs 168/345 (48.7%), setWs: 660/1371 (48.1%), tourneyWs: 13/69 (18.8%)| matchWs 71/325 (21.8%), setWs: 419/1262 (33.2%), tourneyWs: 0/65 (0%)     | || Mugowski matchWinOdds: 80% (20/25), setWinOdds: 68.8% (64/93)     |
| 20:10       | Kotwica, Dawid       | Skórski, Michał      | matchWs 103/280 (36.8%), setWs: 459/1092 (42%), tourneyWs: 3/56 (5.4%)    | matchWs 16/65 (24.6%), setWs: 94/264 (35.6%), tourneyWs: 0/13 (0%)        | || Kotwica matchWinOdds: 75% (6/8), setWinOdds: 65.6% (21/32)        |
================================================================================


================================================================================
==  https://www.tt-series.com/1180-results-11-06-2023-night-tournament-hsc/  ==
================================================================================
______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
| MatchTimeEST| Player 1 Name      | Player 2 Name     | Player 1 Stats                                                            | Player 2 Stats                                                            | Predictions                                                          |
|=====================================================================================================================================================================================================================================================================================|
| 19:20       | Czerwiński, Bartosz| Rutkowski, Mateusz| matchWs 71/190 (37.4%), setWs: 309/744 (41.5%), tourneyWs: 0/38 (0%)      | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Czerwiński matchWinOdds: 33.3% (1/3), setWinOdds: 50% (6/12)      |
| 19:40       | Młynarski, Filip   | Wiśniewski, Karol | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 221/535 (41.3%), setWs: 908/2047 (44.4%), tourneyWs: 9/107 (8.4%) | || Młynarski matchWinOdds: 54.2% (13/24), setWinOdds: 55.3% (57/103) |
| 20:00       | Kapik, Krzysztof   | Jadczyk, Marcin   | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%)  | || Kapik matchWinOdds: 0% (0/9), setWinOdds: 25% (9/36)              |
| 20:20       | Czerwiński, Bartosz| Młynarski, Filip  | matchWs 71/190 (37.4%), setWs: 309/744 (41.5%), tourneyWs: 0/38 (0%)      | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | || Czerwiński matchWinOdds: 0% (0/10), setWinOdds: 30.2% (13/43)     |
| 20:50       | Jadczyk, Marcin    | Rutkowski, Mateusz| matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%)  | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Jadczyk matchWinOdds: 94.4% (17/18), setWinOdds: 88.3% (53/60)    |
| 21:10       | Kapik, Krzysztof   | Wiśniewski, Karol | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 221/535 (41.3%), setWs: 908/2047 (44.4%), tourneyWs: 9/107 (8.4%) | || Kapik matchWinOdds: 50% (11/22), setWinOdds: 50.6% (45/89)        |
| 21:30       | Młynarski, Filip   | Rutkowski, Mateusz| matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Młynarski matchWinOdds: 66.7% (6/9), setWinOdds: 57.1% (20/35)    |
| 21:50       | Czerwiński, Bartosz| Kapik, Krzysztof  | matchWs 71/190 (37.4%), setWs: 309/744 (41.5%), tourneyWs: 0/38 (0%)      | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| || Czerwiński matchWinOdds: 75% (3/4), setWinOdds: 64.7% (11/17)     |
| 22:10       | Jadczyk, Marcin    | Wiśniewski, Karol | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%)  | matchWs 221/535 (41.3%), setWs: 908/2047 (44.4%), tourneyWs: 9/107 (8.4%) | || Jadczyk matchWinOdds: 86.1% (31/36), setWinOdds: 70.4% (100/142)  |
| 22:40       | Młynarski, Filip   | Kapik, Krzysztof  | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| || Młynarski matchWinOdds: 45.5% (5/11), setWinOdds: 53.3% (24/45)   |
| 23:00       | Czerwiński, Bartosz| Jadczyk, Marcin   | matchWs 71/190 (37.4%), setWs: 309/744 (41.5%), tourneyWs: 0/38 (0%)      | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%)  | || Czerwiński matchWinOdds: 0% (0/8), setWinOdds: 14.3% (4/28)       |
| 23:20       | Wiśniewski, Karol  | Rutkowski, Mateusz| matchWs 221/535 (41.3%), setWs: 908/2047 (44.4%), tourneyWs: 9/107 (8.4%) | matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Wiśniewski matchWinOdds: 61.8% (21/34), setWinOdds: 56.5% (78/138)|
| 23:50       | Młynarski, Filip   | Jadczyk, Marcin   | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%)  | || Młynarski matchWinOdds: 25% (4/16), setWinOdds: 35.6% (21/59)     |
| 00:10       | Kapik, Krzysztof   | Rutkowski, Mateusz| matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 202/425 (47.5%), setWs: 799/1645 (48.6%), tourneyWs: 10/85 (11.8%)| || Kapik matchWinOdds: 50% (14/28), setWinOdds: 50.4% (61/121)       |
| 00:30       | Czerwiński, Bartosz| Wiśniewski, Karol | matchWs 71/190 (37.4%), setWs: 309/744 (41.5%), tourneyWs: 0/38 (0%)      | matchWs 221/535 (41.3%), setWs: 908/2047 (44.4%), tourneyWs: 9/107 (8.4%) | || Czerwiński matchWinOdds: 41.7% (5/12), setWinOdds: 45.1% (23/51)  |
================================================================================


================================================================================
==  https://www.tt-series.com/1181-results-12-06-2023-morning-tournament-osp/  ==
================================================================================
_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
| MatchTimeEST| Player 1 Name   | Player 2 Name   | Player 1 Stats                                                            | Player 2 Stats                                                            | Predictions                                                        |
|==============================================================================================================================================================================================================================================================================|
| 00:50       | Jarocki, Łukasz | Wojdyła, Damian | matchWs 201/430 (46.7%), setWs: 804/1664 (48.3%), tourneyWs: 14/86 (16.3%)| matchWs 201/419 (48%), setWs: 786/1590 (49.4%), tourneyWs: 6/84 (7.1%)    | || Jarocki matchWinOdds: 42.9% (12/28), setWinOdds: 45.2% (47/104) |
| 01:10       | Młynarski, Filip| Murawski, Michał| matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 182/375 (48.5%), setWs: 685/1414 (48.4%), tourneyWs: 12/75 (16%)  | || Młynarski matchWinOdds: 66.7% (12/18), setWinOdds: 62.9% (44/70)|
| 01:30       | Kapik, Krzysztof| Korczak, Damian | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 79/165 (47.9%), setWs: 312/653 (47.8%), tourneyWs: 8/33 (24.2%)   | || Kapik matchWinOdds: 40% (4/10), setWinOdds: 47.8% (22/46)       |
| 01:50       | Jarocki, Łukasz | Młynarski, Filip| matchWs 201/430 (46.7%), setWs: 804/1664 (48.3%), tourneyWs: 14/86 (16.3%)| matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | || Jarocki matchWinOdds: 36% (9/25), setWinOdds: 41.1% (39/95)     |
| 02:10       | Korczak, Damian | Wojdyła, Damian | matchWs 79/165 (47.9%), setWs: 312/653 (47.8%), tourneyWs: 8/33 (24.2%)   | matchWs 201/419 (48%), setWs: 786/1590 (49.4%), tourneyWs: 6/84 (7.1%)    | || Korczak matchWinOdds: 33.3% (3/9), setWinOdds: 36.4% (12/33)    |
| 02:40       | Kapik, Krzysztof| Murawski, Michał| matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 182/375 (48.5%), setWs: 685/1414 (48.4%), tourneyWs: 12/75 (16%)  | || Kapik matchWinOdds: 54.5% (6/11), setWinOdds: 52.5% (21/40)     |
| 03:00       | Młynarski, Filip| Wojdyła, Damian | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 201/419 (48%), setWs: 786/1590 (49.4%), tourneyWs: 6/84 (7.1%)    | || Młynarski matchWinOdds: 80% (16/20), setWinOdds: 65.4% (53/81)  |
| 03:20       | Jarocki, Łukasz | Kapik, Krzysztof| matchWs 201/430 (46.7%), setWs: 804/1664 (48.3%), tourneyWs: 14/86 (16.3%)| matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| || Jarocki matchWinOdds: 80% (12/15), setWinOdds: 74.1% (40/54)    |
| 03:50       | Korczak, Damian | Murawski, Michał| matchWs 79/165 (47.9%), setWs: 312/653 (47.8%), tourneyWs: 8/33 (24.2%)   | matchWs 182/375 (48.5%), setWs: 685/1414 (48.4%), tourneyWs: 12/75 (16%)  | || Korczak matchWinOdds: 39.1% (9/23), setWinOdds: 44% (40/91)     |
| 04:10       | Młynarski, Filip| Kapik, Krzysztof| matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| || Młynarski matchWinOdds: 45.5% (5/11), setWinOdds: 53.3% (24/45) |
| 04:30       | Jarocki, Łukasz | Korczak, Damian | matchWs 201/430 (46.7%), setWs: 804/1664 (48.3%), tourneyWs: 14/86 (16.3%)| matchWs 79/165 (47.9%), setWs: 312/653 (47.8%), tourneyWs: 8/33 (24.2%)   | || Jarocki matchWinOdds: 63.2% (12/19), setWinOdds: 61.3% (46/75)  |
| 04:50       | Murawski, Michał| Wojdyła, Damian | matchWs 182/375 (48.5%), setWs: 685/1414 (48.4%), tourneyWs: 12/75 (16%)  | matchWs 201/419 (48%), setWs: 786/1590 (49.4%), tourneyWs: 6/84 (7.1%)    | || Murawski matchWinOdds: 60.9% (14/23), setWinOdds: 56.8% (46/81) |
| 05:20       | Młynarski, Filip| Korczak, Damian | matchWs 147/275 (53.5%), setWs: 562/1074 (52.3%), tourneyWs: 8/55 (14.5%) | matchWs 79/165 (47.9%), setWs: 312/653 (47.8%), tourneyWs: 8/33 (24.2%)   | || Młynarski matchWinOdds: 80% (4/5), setWinOdds: 66.7% (12/18)    |
| 05:40       | Kapik, Krzysztof| Wojdyła, Damian | matchWs 215/405 (53.1%), setWs: 841/1598 (52.6%), tourneyWs: 12/81 (14.8%)| matchWs 201/419 (48%), setWs: 786/1590 (49.4%), tourneyWs: 6/84 (7.1%)    | || Kapik matchWinOdds: 10% (1/10), setWinOdds: 25.6% (10/39)       |
| 06:00       | Jarocki, Łukasz | Murawski, Michał| matchWs 201/430 (46.7%), setWs: 804/1664 (48.3%), tourneyWs: 14/86 (16.3%)| matchWs 182/375 (48.5%), setWs: 685/1414 (48.4%), tourneyWs: 12/75 (16%)  | || Jarocki matchWinOdds: 51.3% (20/39), setWinOdds: 52% (78/150)   |
================================================================================


================================================================================
==  https://www.tt-series.com/1182-results-12-06-2023-morning-tournament-hsc/  ==
================================================================================
___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
| MatchTimeEST| Player 1 Name      | Player 2 Name       | Player 1 Stats                                                           | Player 2 Stats                                                           | Predictions                                                       |
|==================================================================================================================================================================================================================================================================================|
| 01:20       | Floras, Robert     | Gołębiowski, Mateusz| matchWs 68/105 (64.8%), setWs: 237/397 (59.7%), tourneyWs: 7/21 (33.3%)  | matchWs 215/300 (71.7%), setWs: 741/1137 (65.2%), tourneyWs: 27/60 (45%) | || Floras matchWinOdds: 100% (2/2), setWinOdds: 75% (6/8)         |
| 01:40       | Kotowski, Tomasz   | Lewandowski, Patryk | matchWs 88/155 (56.8%), setWs: 335/593 (56.5%), tourneyWs: 6/31 (19.4%)  | matchWs 0/0 (NaN%), setWs: 0/0 (NaN%), tourneyWs: 0/0 (NaN%)             | First Match Together
                                             |
| 02:00       | Chodorski, Piotr   | Jadczyk, Marcin     | matchWs 149/240 (62.1%), setWs: 538/934 (57.6%), tourneyWs: 17/48 (35.4%)| matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%) | || Chodorski matchWinOdds: 66.7% (4/6), setWinOdds: 68.2% (15/22) |
| 02:20       | Floras, Robert     | Kotowski, Tomasz    | matchWs 68/105 (64.8%), setWs: 237/397 (59.7%), tourneyWs: 7/21 (33.3%)  | matchWs 88/155 (56.8%), setWs: 335/593 (56.5%), tourneyWs: 6/31 (19.4%)  | || Floras matchWinOdds: 83.3% (5/6), setWinOdds: 75% (15/20)      |
| 02:50       | Jadczyk, Marcin    | Gołębiowski, Mateusz| matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%) | matchWs 215/300 (71.7%), setWs: 741/1137 (65.2%), tourneyWs: 27/60 (45%) | || Jadczyk matchWinOdds: 15% (3/20), setWinOdds: 30.4% (24/79)    |
| 03:10       | Chodorski, Piotr   | Lewandowski, Patryk | matchWs 149/240 (62.1%), setWs: 538/934 (57.6%), tourneyWs: 17/48 (35.4%)| matchWs 0/0 (NaN%), setWs: 0/0 (NaN%), tourneyWs: 0/0 (NaN%)             | First Match Together
                                             |
| 03:30       | Kotowski, Tomasz   | Gołębiowski, Mateusz| matchWs 88/155 (56.8%), setWs: 335/593 (56.5%), tourneyWs: 6/31 (19.4%)  | matchWs 215/300 (71.7%), setWs: 741/1137 (65.2%), tourneyWs: 27/60 (45%) | || Kotowski matchWinOdds: 57.1% (4/7), setWinOdds: 52% (13/25)    |
| 04:00       | Floras, Robert     | Chodorski, Piotr    | matchWs 68/105 (64.8%), setWs: 237/397 (59.7%), tourneyWs: 7/21 (33.3%)  | matchWs 149/240 (62.1%), setWs: 538/934 (57.6%), tourneyWs: 17/48 (35.4%)| || Floras matchWinOdds: 33.3% (2/6), setWinOdds: 39.1% (9/23)     |
| 04:20       | Jadczyk, Marcin    | Lewandowski, Patryk | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%) | matchWs 0/0 (NaN%), setWs: 0/0 (NaN%), tourneyWs: 0/0 (NaN%)             | First Match Together
                                             |
| 04:40       | Kotowski, Tomasz   | Chodorski, Piotr    | matchWs 88/155 (56.8%), setWs: 335/593 (56.5%), tourneyWs: 6/31 (19.4%)  | matchWs 149/240 (62.1%), setWs: 538/934 (57.6%), tourneyWs: 17/48 (35.4%)| || Kotowski matchWinOdds: 40% (4/10), setWinOdds: 48.7% (19/39)   |
| 05:00       | Floras, Robert     | Jadczyk, Marcin     | matchWs 68/105 (64.8%), setWs: 237/397 (59.7%), tourneyWs: 7/21 (33.3%)  | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%) | || Floras matchWinOdds: 100% (4/4), setWinOdds: 85.7% (12/14)     |
| 05:30       | Lewandowski, Patryk| Gołębiowski, Mateusz| matchWs 0/0 (NaN%), setWs: 0/0 (NaN%), tourneyWs: 0/0 (NaN%)             | matchWs 215/300 (71.7%), setWs: 741/1137 (65.2%), tourneyWs: 27/60 (45%) | First Match Together
                                             |
| 05:50       | Kotowski, Tomasz   | Jadczyk, Marcin     | matchWs 88/155 (56.8%), setWs: 335/593 (56.5%), tourneyWs: 6/31 (19.4%)  | matchWs 273/420 (65%), setWs: 958/1585 (60.4%), tourneyWs: 20/84 (23.8%) | || Kotowski matchWinOdds: 40% (2/5), setWinOdds: 52.4% (11/21)    |
| 06:10       | Chodorski, Piotr   | Gołębiowski, Mateusz| matchWs 149/240 (62.1%), setWs: 538/934 (57.6%), tourneyWs: 17/48 (35.4%)| matchWs 215/300 (71.7%), setWs: 741/1137 (65.2%), tourneyWs: 27/60 (45%) | || Chodorski matchWinOdds: 57.1% (8/14), setWinOdds: 57.1% (32/56)|
| 06:30       | Floras, Robert     | Lewandowski, Patryk | matchWs 68/105 (64.8%), setWs: 237/397 (59.7%), tourneyWs: 7/21 (33.3%)  | matchWs 0/0 (NaN%), setWs: 0/0 (NaN%), tourneyWs: 0/0 (NaN%)             | First Match Together
                                             |
================================================================================
```

