package com.ys.service;

import com.ys.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yushi on 2017/2/16.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})//特定的异常数据回滚
    public Person savePersonWithRollBack(Person person) {

        Person p = personRepository.save(person);
        if (p.getName().equals("喻适")) {
            throw new IllegalArgumentException("喻适已经存在，数据回滚");
        }

        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})//特定的异常数据回滚
    public Person savePersonWithRollOutBack(Person person) {
        Person p = personRepository.save(person);
        if (p.getName().equals("喻适")) {
            throw new IllegalArgumentException("喻适虽然已经存在，但是数据不会回滚");
        }

        return p;
    }
}
