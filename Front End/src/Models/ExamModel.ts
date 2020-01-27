import { CacheModel } from './cacheModel';
import { QuestionModel } from './QuestionModel';
import { UserScoreModel } from './userScoreModel';
import { AdminLoginModel } from './AdminLoginModel';

export class ExamModel{
    constructor(
        examId: number,
        examName : string,
        examDate : string,
        startTime : string,
        endTime : string,
        cacheTable : CacheModel,
        questions : QuestionModel,
        score : UserScoreModel,
        adminLogin : AdminLoginModel
    ){}
}