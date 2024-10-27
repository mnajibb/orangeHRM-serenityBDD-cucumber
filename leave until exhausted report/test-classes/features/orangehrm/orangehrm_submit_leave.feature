Feature: Orange HRM

#  @login
#  Scenario: User want to login
#    Given Sergey try to access Orange HRM login page
#    When he wants to login on Orange HRM with credentials username "Admin" and password "admin123"
#    Then he should be successfully login

  @submit_leave_submit_leave_until_exhausted
  Scenario Outline: User want to submit leave until submit leave quota is exhausted
    Given Sergey wants access HRM Dashboard with admin credentials via login
      When he wants to submit his leave and his current leave balance is "<current_balance>" on selected date "<selected_date>"
      Then he should submit his leave successfully and his leave balance should be reduced by -1 into "<expected_balance>"

    Examples:
      | current_balance | expected_balance   | selected_date   |
      | 23.00 Day(s)    | 22.00 Day(s)       | 1               |
      | 22.00 Day(s)    | 21.00 Day(s)       | 2               |
      | 21.00 Day(s)    | 20.00 Day(s)       | 3               |
      | 20.00 Day(s)    | 19.00 Day(s)       | 4               |
      | 19.00 Day(s)    | 18.00 Day(s)       | 7               |
      | 18.00 Day(s)    | 17.00 Day(s)       | 8               |
      | 17.00 Day(s)    | 16.00 Day(s)       | 9               |
      | 16.00 Day(s)    | 15.00 Day(s)       | 10              |
      | 15.00 Day(s)    | 14.00 Day(s)       | 11              |
      | 14.00 Day(s)    | 13.00 Day(s)       | 14              |
      | 13.00 Day(s)    | 12.00 Day(s)       | 15              |
      | 12.00 Day(s)    | 11.00 Day(s)       | 16              |
      | 11.00 Day(s)    | 10.00 Day(s)       | 17              |
      | 10.00 Day(s)    | 9.00 Day(s)        | 18              |
      | 9.00 Day(s)     | 8.00 Day(s)        | 21              |
      | 8.00 Day(s)     | 7.00 Day(s)        | 22              |
      | 7.00 Day(s)     | 6.00 Day(s)        | 23              |
      | 6.00 Day(s)     | 5.00 Day(s)        | 24              |
      | 5.00 Day(s)     | 4.00 Day(s)        | 25              |
      | 4.00 Day(s)     | 3.00 Day(s)        | 28              |
      | 3.00 Day(s)     | 2.00 Day(s)        | 29              |
      | 2.00 Day(s)     | 1.00 Day(s)        | 30              |
      | 1.00 Day(s)     | 0.00 Day(s)        | 31              |

  @submit_leave_unsifficient_balance
  Scenario Outline: User want to submit leave but got error Balance not sufficient
    Given Sergey wants access HRM Dashboard with admin credentials via login
    When he wants to submit his leave and his current leave balance is "<current_balance>" on selected date "<selected_date>"
    Then he should see message of unsufficient balance

  Examples:
    | current_balance | selected_date   |
    | 0.00 Day(s)     |  1              |