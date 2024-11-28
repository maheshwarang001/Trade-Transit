const LoginService = require("../service/login_service");

const login = async(req,res)=>{

    const data = req.body;

    if(!data.username && !data.password ){
        return res.status(400).json({message : "INVALID CREDENTIALS" , data : ""});
    }

    const userService = await LoginService.checkUserCred(data);

    if(!userService) return res.status(401).json({message : "FAILED" , data : ""});

    return res.status(200).json({message : "SUCCESSFULL" , data : ""});
};

const LoginController = {
    login
}

module.exports = LoginController