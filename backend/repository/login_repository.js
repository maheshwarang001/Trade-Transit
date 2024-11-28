const fs = require('fs');
const path = require('path');

const login = async(username,password)=>{

    const users = getUsersFromFile();

    const user = users.find(user => user.username === username && user.password === password);

    if(!user) return false;

    return true;
}

const getUsersFromFile = () =>{
    const filePath = path.join(__dirname , '../db/login.json');
    const data = fs.readFileSync(filePath,'utf-8');
    return JSON.parse(data);
}

const LoginRepository = {
    login
}

module.exports = LoginRepository