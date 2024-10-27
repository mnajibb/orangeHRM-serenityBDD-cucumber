Feature: Orange HRM Submit Leave with comments

  # please make sure leave balance is 23 before execute this test
  @submit_leave_with_comments
  Scenario Outline: User want to submit leave until submit leave quota is exhausted
    Given Sergey wants access HRM Dashboard with admin credentials via login
    When he wants to submit his leave and his current leave balance is "<current_balance>" on selected date "<selected_date>" with comments "<leave_comments>"
    Then he should submit his leave successfully and his leave balance should be reduced by -1 into "<expected_balance>"
    And he should see that his submitted leave has been recored on My Leave section and check that the status should be correct by "<leave_comments>"

    Examples:
      | current_balance | expected_balance   | selected_date   | leave_comments                       |
      | 23.00 Day(s)    | 22.00 Day(s)       | 1               | submit leave due to flu and diarrhea |