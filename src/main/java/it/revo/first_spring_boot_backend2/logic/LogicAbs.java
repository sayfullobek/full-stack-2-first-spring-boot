package it.revo.first_spring_boot_backend2.logic;

import it.revo.first_spring_boot_backend2.pyload.ReqPhone;
import it.revo.first_spring_boot_backend2.pyload.ResPhone;
import it.revo.first_spring_boot_backend2.pyload.Result;

import java.util.List;

public abstract class LogicAbs {
    public List<ResPhone> getPhoneList() {
        return null;
    }

    public ResPhone getOnePhone(Integer id) {
        return null;
    }

    public Result addPhone(ReqPhone reqPhone) {
        return null;
    }

    public Result editPhone(Integer id, ReqPhone reqPhone) {
        return null;
    }

    public Result deletePhone(Integer id) {
        return null;
    }
}
