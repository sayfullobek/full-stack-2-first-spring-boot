package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Phone;
import it.revo.first_spring_boot_backend2.entity.User;
import it.revo.first_spring_boot_backend2.logic.LogicAbs;
import it.revo.first_spring_boot_backend2.pyload.ReqPhone;
import it.revo.first_spring_boot_backend2.pyload.ResPhone;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService extends LogicAbs {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<ResPhone> getPhoneList() {
        List<Phone> all = phoneRepository.findAll();
        List<ResPhone> resPhones = new ArrayList<>();
        int tr = 1;
        for (Phone phone : all) {
            ResPhone Resphone = ResPhone.builder()
                    .id(phone.getId())
                    .name(phone.getName())
                    .model(phone.getModel())
                    .memory(phone.getMemory())
                    .ram(phone.getRam())
                    .price(phone.getPrice())
                    .build();
            resPhones.add(Resphone);
            tr++;
        }
        return resPhones;
    }

    @Override
    public Result addPhone(ReqPhone reqPhone) {
        if (reqPhone.getPrice() > 0) {
            if (reqPhone.getModel().trim().length() != 0 && reqPhone.getName().trim().length() != 0) {
                Phone phone = Phone.builder()
                        .model(reqPhone.getModel())
                        .memory(reqPhone.getMemory())
                        .ram(reqPhone.getRam())
                        .price(reqPhone.getPrice())
                        .build();
                phone.setName(reqPhone.getName());
                phoneRepository.save(phone);
                return new Result("malumot saqlandi", true);
            }
            return new Result("ism yoki model yuq", false);
        }
        return new Result("narxini kiriting", false);
    }

    @Override
    public Result editPhone(Integer id, ReqPhone reqPhone) {
        Optional<Phone> byId = phoneRepository.findById(id);
        if (byId.isPresent()) {
            Phone phone = byId.get();
            phone.setName(reqPhone.getName());
            phone.setModel(reqPhone.getModel());
            phone.setMemory(reqPhone.getMemory());
            phone.setRam(reqPhone.getRam());
            phone.setPrice(reqPhone.getPrice());
            phoneRepository.save(phone);
            return new Result("malumot taxrirlandi",true);
        }
        return new Result("bunday malumot yuq", false);
    }

    @Override
    public Result deletePhone(Integer id) {
        Optional<Phone> byId = phoneRepository.findById(id);
        if (byId.isPresent()){
            Phone phone = byId.get();
            phoneRepository.delete(phone);
            return new Result("o'chirildi ", true);

        }
        return new Result("bunday malumot yuq", false);
    }

    @Override
    public ResPhone getOnePhone(Integer id) {
        Optional<Phone> byId = phoneRepository.findById(id);
        if (byId.isPresent()) {
            Phone phone = byId.get();
            return ResPhone.builder()
                    .id(phone.getId())
                    .name(phone.getName())
                    .model(phone.getModel())
                    .memory(phone.getMemory())
                    .ram(phone.getRam())
                    .price(phone.getPrice())
                    .build();
        }
        return null;
    }
}
