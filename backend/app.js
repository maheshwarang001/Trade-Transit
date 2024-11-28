const LoginController = require("./controller/login_controller")

const express  = require('express')

const app = express()

const PORT = 3000;

app.use(express.json());

app.get("/", (req,res)=>{

    res.status(200).json("HII");
})

app.post("/login",LoginController.login);


app.listen(PORT,(error)=>{

    if(error){
        console.log(error);
    }else{
        console.log("SERVER RUNNING ON PORT "+ PORT);
    }

});