### Plan

 - [ ] Repeat 
   - [ ] Java
       - [ ] Hash map


 - [ ] New 
   - [ ] Java
     - [ ] Exceptions
     - [ ] Composition, Aggregation, Dependency
     - [ ] Dependency Inversion
     
### Homework
- [ ] New
    - [ ] Java
        - [ ] Exceptions
        - [ ] Composition, Aggregation
        - [ ] Dependency Inversion principle
    - [ ] Check in SimpleHouseRegistrationService for empty houseAddress
  and throw some unchecked exception if houseAddress is empty
    - [ ] Implement get method in SimpleHouseRegistrationService
    - [ ] Write tests for SimpleHouseRegistrationService*

### Notes

                     Throwable  
            /                       \
        Exception (Checked)          Error - OutOfMemorryError
            |                \                      
        IOException         RuntimeException (Uncheked) 
            |                   \
        FileNotFoundException    NullPointerException
