import { UserRegisterModel } from './UserRegisterModel';
import { ExamModel } from './examModel';

export class UserScoreModel{
    constructor(
        userScoreId : number,
        userEmail : string,
        examName : string,
        score : number,
        dateOfExam : string,
        timeTaken : number
    ){}
}