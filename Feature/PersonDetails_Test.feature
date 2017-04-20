#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Person Form Submit
	I want to use this template for my feature file

@tag1
Scenario: Submit valid person details
Given User is on Person Form
When User enters Name and Age
Then Message field about success is displayed

@tag2
Scenario: Submit valid person details - Parametrized
	Given User is on Person Form
	When User enters "Testname" and "60"
	Then Message field about success is displayed

@tag3
Scenario Outline: Submit valid person details - Parametrized using examples
	Given User is on Person Form
	When User enters "<name>" and "<age>"
	Then Message field about success is displayed
Examples:
| name      | age  |
| testname1 | 30   |
| testname2 | 40   |
| testname3 | 50   |

@tag4
Scenario Outline: Submit invalid name
	Given User is on Person Form
	When User enters "<name>" and "<age>"
	Then Validation error for name is displayed
Examples:
| name      | age  |
| t   		  | 30   |
|       		| 10   |
| 1   		  | 10   |

@tag5
Scenario Outline: Submit invalid age
	Given User is on Person Form
	When User enters "<name>" and "<age>"
	Then Validation error for age is displayed
Examples:
| name      | age  |
| test 			| 60   |
| test 			| 60   |
| 1   		  | 10   |
