Feature: service
As a user of the service when I get it to read files, the service to be able to enter a vehicle registration number and
get the correct make and colour of the cars I own back from the website. This means I don't have to do it manually.


Scenario Outline: The user has <number> files to read by the service
Given the service has <number> files to read in directory <path>
When the service is evoked
Then the service will produce a list of size <result>
Examples:
| number | path       | result |
| 1      | testfiles1 | 1      |
| 2      | testfiles2 | 2      |
| 3      | testfiles3 | 3      |
| 14     | testfiles  | 13     |


Scenario Outline: The user has files to read by the service in directory testfiles1
Given the service has <number> files to read in directory <path>
When the service is evoked
And the registration number <plate> from <file> is entered into the website
Then the website details will match the service with make of FORD with a colour of BLUE
Examples:
| number | path       | plate   | file      |
| 1      | testfiles1 | NG07NNT | file1.csv |

Scenario Outline: The information in the files read by the service can be found or not found on the website
Given the service reads files from directory testfiles
When the service is evoked
And registration numbers from each file with <name> is entered into the website inturn
Then the website details for registration <plate> will be <foundOrNot> the exact vehicle make <make> with colour <colour>
Examples:
 | name     | plate   | foundOrNot | make    | colour |
 |file1.csv | NG07NNT | found      | FORD    | BLUE   |
 |file2.csv | GX18HBL | found      | AUDI    | BLACK  |
 |file3.csv | V765DPR | not found  | HYUNDAI | SILVER |
 |file4.csv | GJ13EBK | found      | HONDA   | RED    |
 |file5.csv | LA12GZC | found      | NISSAN  | BLUE   |
 |file6.csv | GJ13EBX | found      | CITROEN | WHITE  |
 |file7.csv | YS59ABZ | found      | BMW     | BLUE   |
 |file8.csv | P1LOT   | found      | BMW     | BLACK  |
 |file9.csv | PK66PFF | found      | MINI    | BLUE   |
 |file10.csv| RK66PFF | found      | AUDI    | WHITE  |
 |file11.csv| 1234567 | error      | BMW     | ORANGE |
 |file12.csv| GX18HBK | found      | AUDI    | BLUE   |
 |file14.csv| NG08NNT | found      | FORD    | BLACK  |

Scenario Outline: The information in the files read by the service match or not match the details on the website
Given the service reads files from directory testfiles
When the service is evoked
And registration numbers from each file with <name> is entered into the website inturn
Then the website details for registration <plate> with make of <make> with a colour of <colour>  will <matchOrNot> the service with make of <make1> with a colour of <colour1>
Examples:
 | name      | plate   | make    | colour | matchOrNot   | make1   | colour1 |
 | file1.csv | NG07NNT | FORD    | BLUE   | match        | FORD    | BLUE    |
 | file2.csv | GX18HBL | AUDI    | BLACK  | match        | AUDI    | BLACK   |
 | file3.csv | V765DPR | HYUNDAI | SILVER | not match    | HYUNDAI | SILVER  |
 | file4.csv | GJ13EBK | HONDA   | RED    | match        | HONDA   | RED     |
 | file5.csv | LA12GZC | NISSAN  | BLUE   | match        | NISSAN  | BLUE    |
 | file6.csv | GJ13EBX | CITROEN | WHITE  | match        | CITROEN | WHITE   |
 | file7.csv | YS59ABZ | BMW     | BLUE   | match        | BMW     | BLUE    |
 | file8.csv | P1LOT   | BMW     | BLACK  | match        | BMW     | BLACK   |
 | file9.csv | PK66PFF | MINI    | BLUE   | match        | MINI    | BLUE    |
 | file10.csv| RK66PFF | AUDI    | WHITE  | match        | AUDI    | WHITE   |
 | file11.csv| 1234567 | BMW     | ORANGE | error        | BMW     | ORANGE  |
 | file12.csv| GX18HBK | AUDI    | BLUE   | not be found | BMW     | BLUE    |
 | file14.csv| NG08NNT | FORD    | BLACK  | match        | FORD    | BLACK   |