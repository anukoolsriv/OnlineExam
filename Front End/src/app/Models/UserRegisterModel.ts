export class UserRegisterModel {
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public mobile: number,
        public dateOfBirth: Date,
        public state: string,
        public city: string,
        public qualification: string,
        public yearOfCompletion: number
    ){}
}