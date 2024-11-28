

const LoginRepository = require("../repository/login_repository");

const checkUserCred = async(data)=>{
    const check = await LoginRepository.login(data.username,data.password);
    console.log(check);
    return check;
}

const LoginService = {
    checkUserCred
}

module.exports = LoginService