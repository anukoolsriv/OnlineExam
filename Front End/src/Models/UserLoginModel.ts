import { UserRegisterModel } from './UserRegisterModel';

export class UserLogin {
    constructor(
        public  userId:number,
        public email:string,
        public password:string,
        public otp:string,
        public user : UserRegisterModel
    ){}
}
