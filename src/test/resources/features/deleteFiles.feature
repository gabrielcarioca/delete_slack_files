@DeleteFilesFeature
Feature: Delete Files

Background:
    Given User goes to files management page

Scenario: Delete the ten older image files
    When User goes to the last page of image files and delete ten image files