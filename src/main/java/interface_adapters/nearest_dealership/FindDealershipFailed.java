package interface_adapters.nearest_dealership;

public class FindDealershipFailed extends RuntimeException{
    public FindDealershipFailed(String error) { super(error); }
}

