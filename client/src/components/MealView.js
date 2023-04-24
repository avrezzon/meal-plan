import {
  Card,
  CardBody,
  CardTitle,
  Col,
  ListGroup,
  ListGroupItem,
} from "reactstrap";

export const MealView = (props) => {
  return props.meal.servingPortions.map((serving) => (
    <Col key={`${props.meal.name}-${serving.type}-details`}>
      <Card body>
        <CardTitle>{`${serving.servingQty} serving of ${serving.type}`}</CardTitle>
        <CardBody>
          <ListGroup>
            {serving.foodList.map((item, index) => (
              <ListGroupItem
                key={`${props.meal.name}-${item.type}-food-element-${index}`}
              >{`${item.servingSize} ${item.unitOfMeasure} of ${item.name}`}</ListGroupItem>
            ))}
          </ListGroup>
        </CardBody>
      </Card>
    </Col>
  ));
};
