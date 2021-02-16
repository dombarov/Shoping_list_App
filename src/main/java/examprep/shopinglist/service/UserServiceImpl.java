package examprep.shopinglist.service;

import examprep.shopinglist.model.entity.User;
import examprep.shopinglist.model.service.UserServiceModel;
import examprep.shopinglist.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper
                .map(this.userRepository.saveAndFlush(user), UserServiceModel.class);

    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
