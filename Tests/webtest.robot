*** Setting ***
Documentation                   This is some basic infor about the whole test suite
Library                         SeleniumLibrary
Test Setup                      Begin Web Test
Test Teardown                   End Web Test
*** Variables ***
${BROWSER}                      chrome
${URL}                          https://www.willys.se/
*** Keywords ***
Begin Web Test
    Open browser                about:blank     chrome
    set selenium speed          1
Go To Web Page
    Load Page
    Verify Page Loaded
Load Page
    Go to                       https://www.willys.se/
Verify Page Loaded
    Wait until Page Contains    Handla billig mat online
Search For Product
    Enter Search Term
    Submit Search
    Verify Search Completed
Enter Search Term
    Input Text                  id=selenium--search-items-input   kiwi
Submit Search
    Press Keys                  xpath://input[@id="selenium--search-items-input"]       RETURN
    Press Keys                  xpath://input[@id="selenium--search-items-input"]       RETURN
Verify Search Completed
    Wait until Page Contains    Sökord: kiwi
End Web Test
    Close Browser
*** Test Cases ***
User can access website
    [Documentation]             This is some basic info about the test
    [Tags]                      Test 1
    Begin Web Test
    Go To Web Page
    Search For Product
    End Web Test



