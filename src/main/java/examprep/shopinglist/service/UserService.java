package examprep.shopinglist.service;

import examprep.shopinglist.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
