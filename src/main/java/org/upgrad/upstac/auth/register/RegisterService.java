package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.UserRole;

import java.time.LocalDateTime;
import static org.upgrad.upstac.shared.DateParser.getDateFromString;

@Service
public class RegisterService {

    @Autowired
    private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);


    public User addUser(RegisterRequest user) {

/*      User should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.USER)
                status should be set to AccountStatus.APPROVED

        And finally
            Call userService.saveInDatabase to save the new user and return the saved user
*/
        if((null!=userService.findByUserName(user.getUserName())))
            throw new AppException("Username is already exists " + user.getUserName());
        if((null!=userService.findByEmail(user.getEmail())))
            throw new AppException("Email address already exists " + user.getEmail());
        if((null!= userService.findByPhoneNumber(user.getPhoneNumber())))
            throw new AppException("Phone number already exists " + user.getPhoneNumber());

        User nUser = new User();
        nUser.setUserName(user.getUserName());
        nUser.setPassword(userService.toEncrypted(user.getPassword()));
        nUser.setFirstName(user.getFirstName());
        nUser.setLastName(user.getLastName());
        nUser.setGender(user.getGender());
        nUser.setDateOfBirth(getDateFromString(user.getDateOfBirth()));
        nUser.setAddress(user.getAddress());
        nUser.setEmail(user.getEmail());
        nUser.setPhoneNumber(user.getPhoneNumber());
        nUser.setPinCode(user.getPinCode());
        nUser.setRoles(userService.getRoleFor(UserRole.USER));
        nUser.setCreated(LocalDateTime.now());
        nUser.setUpdated(LocalDateTime.now());
        nUser.setStatus(AccountStatus.APPROVED);
        User updatedUser = userService.saveInDatabase(nUser);
        //throw new AppException("Method Not Implemented");

        return updatedUser;
    }

    public User addDoctor(RegisterRequest user) {


/*      Doctor should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.DOCTOR)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save the newly registered doctor and return the saved value
*/
        if((null!=userService.findByUserName(user.getUserName())))
            throw new AppException("Username is already exists " + user.getUserName());
        if((null!=userService.findByEmail(user.getEmail())))
            throw new AppException("Email address already exists " + user.getEmail());
        if((null!= userService.findByPhoneNumber(user.getPhoneNumber())))
            throw new AppException("Phone number already exists " + user.getPhoneNumber());

        User nUser = new User();
        nUser.setUserName(user.getUserName());
        nUser.setPassword(userService.toEncrypted(user.getPassword()));
        nUser.setFirstName(user.getFirstName());
        nUser.setLastName(user.getLastName());
        nUser.setGender(user.getGender());
        nUser.setDateOfBirth(getDateFromString(user.getDateOfBirth()));
        nUser.setAddress(user.getAddress());
        nUser.setEmail(user.getEmail());
        nUser.setPhoneNumber(user.getPhoneNumber());
        nUser.setPinCode(user.getPinCode());
        nUser.setRoles(userService.getRoleFor(UserRole.USER));
        nUser.setCreated(LocalDateTime.now());
        nUser.setUpdated(LocalDateTime.now());
        nUser.setStatus(AccountStatus.APPROVED);
        User updatedUser = userService.saveInDatabase(nUser);
        //throw new AppException("Method Not Implemented");

        return updatedUser;
        //throw new AppException("Method Not Implemented");
    }


    public User addTester(RegisterRequest user) {


/*      Tester should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.TESTER)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save newly registered tester and return the saved value
*/

        if((null!=userService.findByUserName(user.getUserName())))
            throw new AppException("Username is already exists " + user.getUserName());
        if((null!=userService.findByEmail(user.getEmail())))
            throw new AppException("Email address already exists " + user.getEmail());
        if((null!= userService.findByPhoneNumber(user.getPhoneNumber())))
            throw new AppException("Phone number already exists " + user.getPhoneNumber());

        User nUser = new User();
        nUser.setUserName(user.getUserName());
        nUser.setPassword(userService.toEncrypted(user.getPassword()));
        nUser.setFirstName(user.getFirstName());
        nUser.setLastName(user.getLastName());
        nUser.setGender(user.getGender());
        nUser.setDateOfBirth(getDateFromString(user.getDateOfBirth()));
        nUser.setAddress(user.getAddress());
        nUser.setEmail(user.getEmail());
        nUser.setPhoneNumber(user.getPhoneNumber());
        nUser.setPinCode(user.getPinCode());
        nUser.setRoles(userService.getRoleFor(UserRole.USER));
        nUser.setCreated(LocalDateTime.now());
        nUser.setUpdated(LocalDateTime.now());
        nUser.setStatus(AccountStatus.APPROVED);
        User updatedUser = userService.saveInDatabase(nUser);
        //throw new AppException("Method Not Implemented");

        return updatedUser;
        //throw new AppException("Method Not Implemented");
    }


}
