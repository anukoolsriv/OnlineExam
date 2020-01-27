import { UserRegisterModel } from './UserRegisterModel';
import { ExamModel } from './examModel';

export class UserScoreModel{
    constructor(
        userScoreId : number,
        user : UserRegisterModel,
        exam : ExamModel,
        scorePerAttempt : number,
        dateOfExam : string,
        timeTaken : number
    ){}
}