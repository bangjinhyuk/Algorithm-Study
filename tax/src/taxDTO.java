/**
 * Created by bangjinhyuk on 2021/11/04.
 */
public class taxDTO {
    int total = -1;
    int IncomeTax = -1;
    int localIncomeTax = -1;

    int loanPaymentAmount;

    int IncomeTax2 = -1;
    int localIncomeTax2 = -1;
    int total2 = -1;

    public int getLoanPaymentAmount() {
        return loanPaymentAmount;
    }

    public int getTotal() {
        return total;
    }

    public int getIncomeTax() {
        return IncomeTax;
    }

    public int getLocalIncomeTax() {
        return localIncomeTax;
    }

    public int getIncomeTax2() {
        return IncomeTax2;
    }

    public int getLocalIncomeTax2() {
        return localIncomeTax2;
    }

    public int getTotal2() {
        return total2;
    }

    public taxDTO(double loanPaymentAmount) {
        double IncomeTax;
        double localIncomeTax;
        double total;
        double tax = 10.0;
        int flag = 0;
        while(true){
            total =  tax+ loanPaymentAmount;
            IncomeTax = total*0.03;
            localIncomeTax = ((total*0.03)-(total*0.03)%10)*0.1;
            if((IncomeTax-IncomeTax%10)+ (localIncomeTax-localIncomeTax%10) ==tax && loanPaymentAmount ==total-(IncomeTax-IncomeTax%10)-(localIncomeTax-localIncomeTax%10)){
                if(flag == 0){
                    this.total = (int) total;
                    this.IncomeTax =  (int) (IncomeTax-IncomeTax%10);
                    this.localIncomeTax = (int) (localIncomeTax-localIncomeTax%10);
                    flag++;
                }else if(flag == 1){
                    this.total2 = (int) total;
                    this.IncomeTax2 =  (int) (IncomeTax-IncomeTax%10);
                    this.localIncomeTax2 = (int) (localIncomeTax-localIncomeTax%10);
                    break;
                }
            }
            if(tax>loanPaymentAmount/10) break;
            tax+=10;
        }
        this.loanPaymentAmount = (int) loanPaymentAmount;

    }
}
