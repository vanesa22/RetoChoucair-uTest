# Autor:LeidyFernandez
@stories
Feature: Academy Choucair
  As a user, II want to learn how to automate in screamplay at the Choucair Academy with the automation course
  @scenario1
  Scenario: Automated registration in uTest
    Given Rose wants to register on the uTest platform

    When she registers all the data requested by the platform
      |strFirstName|strLastName|strEmail               |strMonth|strDay |strYear|strPassword|strPasswordConfirmation| strCity|strZip|strComputer|strVersion|strLenguaje|
      |Rose        |Fernandez  |vanesa089-31@hotmail.com|February|11     |1997   |Choucair1* |Choucair1*             |Popayán |190003|Windows   |10        |Spanish    |

    Then she will be registered
